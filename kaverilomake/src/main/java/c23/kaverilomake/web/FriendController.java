package c23.kaverilomake.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import c23.kaverilomake.domain.Friend;

@Controller
public class FriendController {
    //Alustus
    List<Friend> friends = new ArrayList<>();
    public FriendController() {
        friends.add(new Friend("Matti", "Meikälainen"));
        friends.add(new Friend("Maija", "Tuulinen"));
    }
    //Näyttää listan
    @GetMapping("/friends")
    public String getFriendList(Model model) {
        model.addAttribute("friends", friends);
        return "friendlist";
    }
    //Kaveri lomake
    @GetMapping("/addfriend")
    public String getAddFriendForm(Model model) {
        model.addAttribute("friend", new Friend());
        return "friendform";
    }
    //Tallentaa kaveri listalle ja palaa /friends sivulle
    @PostMapping("/addfriend")
    public String saveAddFriend(@ModelAttribute Friend friend) {
        friends.add(friend);
        return "redirect:/friends";
    }
}

