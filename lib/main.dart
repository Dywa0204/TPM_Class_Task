import 'package:flutter/material.dart';

void main() {
  runApp(const MaterialApp(
    home: LoginForm(),
  ));
}

class LoginForm extends StatelessWidget {
  const LoginForm({super.key});
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
                Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: TextFormField(
                    cursorColor: Colors.red,
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
                Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: TextFormField(
                    cursorColor: Colors.red,
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
              ],
            ),
          )
        )
      ),
    );
  }
}