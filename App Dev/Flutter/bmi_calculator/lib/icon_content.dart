import 'package:flutter/material.dart';
import 'constants.dart';
class Icon_widget extends StatelessWidget {
  Icon_widget({required this.icon, required this.label});

  final IconData icon;
  final String label;
  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Icon(
          icon,
          size: 80.0,
        ),
        SizedBox(
          height: 15.0,
        ),
        Text(
          label,
          style: labeltextstyle,
        ),
      ],
    );
  }
}
