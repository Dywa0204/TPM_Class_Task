import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class Kelompok {
  String nama = "";
  String nim = "";

  Kelompok(this.nama, this.nim);
}

class KelompokApp extends StatefulWidget {
  const KelompokApp({Key? key}) : super(key: key);

  @override
  State<KelompokApp> createState() => _KelompokAppState();
}

class _KelompokAppState extends State<KelompokApp> {
  String calcText = "0";
  List<String> calcNumber = [""];
  int calcCurrentIndex = 0;
  bool isOperatorClicked = false;

  List<Kelompok> kelompok = [
    Kelompok("Kamila Richana Fauziyah", "123200031"),
    Kelompok("Dywa Pratama Haswanto Putra", "123200041")
  ];

  void onCalcButtonPressed(int number) {
    String text = (number + 1).toString();

    if(number < 9) {
      calcNumber[calcCurrentIndex] += (number + 1).toString();
      isOperatorClicked = false;
    }

    if(!isOperatorClicked) {
      switch(number) {
        case 9 :
          text = " + ";
          calcCurrentIndex++;
          calcNumber.add("");
          isOperatorClicked = true;
          break;
        case 10 :
          text = " - ";
          calcCurrentIndex++;
          calcNumber.add("-");
          isOperatorClicked = true;
          break;
        case 11 :
          calcText = "0";
          text = calcNumber.fold("0", (p, c) => (int.parse(p) + int.parse(c)).toString());
          calcCurrentIndex = 0;
          calcNumber.removeRange(1, calcNumber.length);
          calcNumber[calcCurrentIndex] = text;
          break;
      }

      calcText = (calcText == "0") ? "" : calcText;
      calcText += text;
    }

    print(calcNumber);
  }

  @override
  Widget build(BuildContext context) {
    List<ElevatedButton> calcButton = List.generate(
        12, (index) {
      String text = (index + 1).toString();

      switch(index) {
        case 9 : text = " + "; break;
        case 10 : text = " - "; break;
        case 11 : text = " = "; break;
      }

      return ElevatedButton(
        style: ElevatedButton.styleFrom(
          backgroundColor: const Color(0xffF18265)
        ),
        onPressed: () {
          setState(() {
            onCalcButtonPressed(index);
          });
        },
        child: Text(
          text,
          style: const TextStyle(
              fontSize: 28
          ),
        ),
      );
    }
    );

    return MaterialApp(
      home: Scaffold(
          appBar: AppBar(
            title: const Text("Menu Anggota Kelompok dan Kalkulator"),
            backgroundColor: const Color(0xffF18265),
          ),
          body: Column(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: [

              //Anggota Kelompok
              Container(
                  color: CupertinoColors.systemGrey5,
                  height: 280,
                  child: Center(
                    child: ListView.builder(
                      shrinkWrap: true,
                      scrollDirection: Axis.horizontal,
                      itemCount: kelompok.length,
                      itemBuilder: (context, index) {
                        return Container(
                          decoration: const BoxDecoration(
                              borderRadius: BorderRadius.all(Radius.circular(15)),
                              color: Colors.white
                          ),
                          padding: const EdgeInsets.all(20),
                          margin: const EdgeInsets.all(20),
                          width: 200,
                          child: Column(
                            mainAxisAlignment: MainAxisAlignment.spaceBetween,
                            children: [
                              const Image(
                                image: AssetImage(
                                    "images/user.png"
                                ),
                                width: 120,
                              ),
                              Text(
                                "${kelompok[index].nama}\n[ ${kelompok[index].nim} ]",
                                textAlign: TextAlign.center,
                                style: const TextStyle(
                                    fontSize: 20
                                ),
                              )
                            ],
                          ),
                        );
                      },
                    ),
                  )
              ),

              //Kalkulator Text
              Container(
                color: CupertinoColors.systemGrey5,
                padding: const EdgeInsets.all(32),
                child: Row(
                  children: [
                    Expanded(
                      flex: 1,
                      child: Container(
                        color: Colors.white,
                        height: 60,
                        alignment: Alignment.center,
                        child: Text(
                          calcText,
                          style: const TextStyle(
                              fontSize: 24
                          ),
                        ),
                      ),
                    ),
                    TextButton(
                        onPressed: () {
                          setState(() {
                            calcCurrentIndex = 0;
                            calcText = "0";
                            calcNumber.removeRange(1, calcNumber.length);
                            calcNumber[0] = "";
                            isOperatorClicked = false;
                          });
                        },
                        child: Icon(Icons.close)
                    )
                  ],
                )
              ),

              //Kalkulatorn Button
              Expanded(
                flex: 1,
                child: Container(
                  padding: const EdgeInsets.all(32),
                  color: CupertinoColors.systemGrey5,
                  child: GridView(
                    gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
                      crossAxisCount: 3,
                      crossAxisSpacing: 10,
                      mainAxisSpacing: 10,
                    ),
                    children: calcButton,
                  ),
                ),
              )
            ],
          )
      ),
    );
  }
}
