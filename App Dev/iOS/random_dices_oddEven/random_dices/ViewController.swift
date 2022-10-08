//
//  ViewController.swift
//  random_dices
//
//  Created by MAYANK NAILWAL on 04/10/22.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var DiceImageOne: UIImageView!
    
    @IBOutlet weak var DiceImageTwo: UIImageView!
    
   
    
    @IBAction func RollButton(_ sender: Any)
    {
        
        let diceArray = [#imageLiteral(resourceName: "DiceOne"), #imageLiteral(resourceName: "DiceTwo"), #imageLiteral(resourceName: "DiceThree"), #imageLiteral(resourceName: "DiceFour"), #imageLiteral(resourceName: "DiceFive"), #imageLiteral(resourceName: "DiceSix")]  //made a constant array for diceiamges that can be further be used
        
        DiceImageOne.image = diceArray[Int.random(in: 0...5)]    // we can use randomElement() rather than using Int.random function
        DiceImageTwo.image = diceArray.randomElement()
        
        
    }
    

}

