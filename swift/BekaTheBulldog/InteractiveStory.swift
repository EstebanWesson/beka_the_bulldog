//
//  InteractiveStory.swift
//  BekaTheBulldog
//
//  Created by Esteban Wesson on 8/17/16.
//  Copyright © 2016 Esteban Wesson. All rights reserved.
//

import Foundation
import UIKit

enum Story {
    case page0(String)
    case page1
    case page1_2
    case page2(String)
    case page3
    case page4
    case page4_2
    case page5
    case page6
    
    var rawValue: String {
        switch self {
        case .page0: return "page0"
        case .page1: return "page1"
        case .page1_2: return "page1"
        case .page2: return "page2"
        case .page3: return "page3"
        case .page4: return "page4"
        case .page4_2: return "page4"
        case .page5: return "page5"
        case .page6: return "page6"
        }
    }
}

extension Story {
    var artwork: UIImage {
        return UIImage(named: self.rawValue)!
    }
    var text: String {
        switch self {
        case .page0(let name):
            return "Hello \(name)! This is Beka. She is sleeping now but she would like to go on an adventure with you. What would you like to do first?"
        case .page1:
            return "You and Beka are having so much fun! Her friends show up and want to play with you too but you might be a little tired from all the running around. What do you want to do?"
        case .page1_2:
            return "You are having a lot of fun with Beka in the park! She suddenly notices some of her friends but the two of you are also a bit tired from playing so much."
        case .page2(let name):
            return "You and Beka go for a car ride. You both have your seatbelt ON so you can enjoy the ride safely. Beka wants to put her head out the window but she also wants to go to the park. What do you want  \(name)?"
        case .page3:
            return "Beka loves the air on her face, but she also wants you to know that you shouldn't do it. Now Beka is a little tired"
        case .page4:
            return "Wohooo! You are having a great time with Beka, Gatsby, and Oliver. Now you are really getting tired. Do you want to..."
        case .page4_2:
            return "You and Beka play with her friends and have a lot of fun, but now the two of you are kind of tired."
        case .page5:
            return "You and Beka take a nap together and then you say goodbye to her."
        case .page6:
            return "After a beautiful day with Beka, you let her play calmly with her favorite toy. You are both very happy and a little tired so it is better if you rest until your next adventure. "
        }
    }
}

struct Adventure {
    static func adventure(_ name: String) -> Page {
        let page0 = Page(story: .page0(name))
        let page1 = page0.addChoice("to_page1", story: .page1)
        let page2 = page0.addChoice("to_page2", story: .page2(name))
        
        let page4 = page1.addChoice("to_page4", story: .page4)
        page1.addChoice("to_page5", story: .page5)
        
        let page1_2 = page2.addChoice("to_page1", story: .page1_2)
        let page3 = page2.addChoice("to_page3", story: .page3)
        
        let page4_2 = page1_2.addChoice("to_page4", story: .page4_2)
        page1_2.addChoice("to_page5", story: .page5)
        
        page3.addChoice("to_page5", story: .page5)
        page3.addChoice("to_page6", story: .page6)
       
        page4.addChoice("to_page5", story: .page5)
        page4.addChoice("to_page6", story: .page6)
        
        page4_2.addChoice("to_page5", story: .page5)
        page4_2.addChoice("to_page6", story: .page6)
        
        
        
        return page0
    }
}


class Page {
    let story: Story
    
    typealias Choice = (buttonImage: String, page: Page)
    
    var firstChoice: Choice?
    var secondChoice: Choice?
    
    init(story: Story) {
        self.story = story
    }
}




extension Page {
    func addChoice(_ buttonImage: String, story: Story) -> Page {
        let page = Page(story: story)
        return addChoice(buttonImage, page: page)
    }
    
    func addChoice(_ buttonImage: String, page: Page) -> Page {
        switch (firstChoice, secondChoice) {
        case (.some, .some): break
        case (.none, .none), (.none, .some):
            firstChoice = (buttonImage, page)
        case (.some, .none):
            secondChoice = (buttonImage, page)
            }
        return page
    }
}













