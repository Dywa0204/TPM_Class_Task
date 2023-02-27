import 'package:flutter/material.dart';
import 'package:tugas1/secondPage.dart';

void main() {
  runApp(const MaterialApp(
    home: LoginForm(),
  ));
}

final TextEditingController usernameController = TextEditingController();
final TextEditingController passwordController = TextEditingController();

class LoginForm extends StatelessWidget {
  const LoginForm({super.key});

  void onLogin(BuildContext context) {
    String username = usernameController.text.toString();
    String password = passwordController.text.toString();

    if(username == "admin" && password == "admin") {
      Navigator.of(context).push(
          MaterialPageRoute(builder: (context) {
            return const KelompokApp();
          })
      );
    } else {
      showDialog(
          context: context,
          builder: (context) {
            return const AlertDialog(
              icon: Icon(Icons.cancel),
              iconColor: Colors.red,
              title: Text("Username atau Password Salah"),
            );
          }
      );
    }
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: Container(
          alignment: Alignment.center,
          child: Container(
            height: 400,
            padding: const EdgeInsets.all(32),
            child: Column(
              children: [
                Text(
                  'Welcome',
                  style: TextStyle(
                      color: Colors.red[900],
                      fontSize: 32,
                      letterSpacing: 4.0,
                      fontWeight: FontWeight.bold),
                ),

                //Username
                Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: TextFormField(
                    controller: usernameController,
                    cursorColor: const Color(0xffF18265),
                    decoration: InputDecoration(
                      enabledBorder: OutlineInputBorder(
                        borderSide: const BorderSide(color: Colors.red, width: 2.0),
                        borderRadius: BorderRadius.circular(50),
                      ),
                      contentPadding: const EdgeInsets.only(
                          left: 30.0, top: 20.0, bottom: 20.0),
                      focusedBorder: OutlineInputBorder(
                        borderSide: const BorderSide(color: Colors.red, width: 2.0),
                        borderRadius: BorderRadius.circular(50.0),
                      ),
                      suffixIcon: const Icon(
                        Icons.person,
                        color: Colors.red,
                      ),
                      labelText: ('Username'),
                      labelStyle: const TextStyle(color: Colors.red),
                    ),
                  ),
                ),

                //Password
                Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: TextFormField(
                    controller: passwordController,
                    cursorColor: const Color(0xffF18265),
                    decoration: InputDecoration(
                      enabledBorder: OutlineInputBorder(
                        borderSide: const BorderSide(color: Colors.red, width: 2.0),
                        borderRadius: BorderRadius.circular(50.0),
                      ),
                      contentPadding: const EdgeInsets.only(
                          left: 30.0, top: 20.0, bottom: 20.0),
                      focusedBorder: OutlineInputBorder(
                        borderSide: const BorderSide(color: Colors.red, width: 2.0),
                        borderRadius: BorderRadius.circular(50.0),
                      ),
                      suffixIcon: const Icon(
                        Icons.lock,
                        color: Colors.red,
                      ),
                      labelText: ('Password'),
                      labelStyle: const TextStyle(color: Colors.red),
                    ),
                  ),
                ),

                TextButton(
                  style: TextButton.styleFrom(
                    backgroundColor: const Color(0xffF18265),
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(30),
                    ),
                    padding: EdgeInsets.all(20)
                  ),
                  onPressed: () {
                    onLogin(context);
                  },
                  child: const Text(
                    "LOGIN",
                    style: TextStyle(
                      color: Color(0xffffffff),
                    ),
                  ),
                ),
              ],
            ),
          )
        )
      ),
    );
  }
}