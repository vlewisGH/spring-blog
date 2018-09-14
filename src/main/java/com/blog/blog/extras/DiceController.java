package com.blog.blog.extras;

import com.blog.blog.extras.Guess;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Random;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String diceGameInit(Model model){
        model.addAttribute("guess", new Guess());
        return "roll-dice/index";
    }

    @PostMapping("/roll-dice")
    public String diceGame(@ModelAttribute Guess guess, Model returnModel){

        int randoNum = getRando();
        if (guess.getGuess() == randoNum){
            returnModel.addAttribute("response", "You win");
        }else{
            returnModel.addAttribute("response", "You lose");
        }

        returnModel.addAttribute("userGuess",guess.getGuess());

        returnModel.addAttribute("randoNum", randoNum);

        return "roll-dice/index";
    }

    public int getRando(){
        return new Random().nextInt(6)+1;
    }

}
