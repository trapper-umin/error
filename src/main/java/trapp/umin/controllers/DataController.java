package trapp.umin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import trapp.umin.dao.DataDAO;

@Controller
@RequestMapping("/data")
public class DataController {
    private final DataDAO dataDAO;

    @Autowired
    public DataController(DataDAO dataDAO){
        this.dataDAO=dataDAO;
    }

    @GetMapping()
    public String show(Model model){
        model.addAttribute("data",dataDAO.show());

        return "show";
    }
}
