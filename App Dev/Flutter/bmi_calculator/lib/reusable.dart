import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';

class Reusable_Widget extends StatelessWidget {
  final Color rang;
  final Widget cardChild;

  Reusable_Widget({
    required this.cardChild,
    required this.rang,
  });

  @override
  Widget build(BuildContext context) {
    return Expanded(
      child: Container(
        child: cardChild,
        margin: EdgeInsets.all(15.0),
        decoration: BoxDecoration(
          color: rang,
          borderRadius: BorderRadius.circular(10.0),
        ),
      ),
    );
  }
}
