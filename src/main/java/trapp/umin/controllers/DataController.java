package trapp.umin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import trapp.umin.dao.DataDAO;
import trapp.umin.models.Data;

import javax.validation.Valid;

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

    @GetMapping("/{id}")
    public String index(@PathVariable("id") int id, Model model){
        model.addAttribute("data",dataDAO.index(id));

        return "index";
    }

    @GetMapping("/new")
    public String create(Model model){
        model.addAttribute("data",new Data());

        return "create";
    }

    @PostMapping
    public String createPost(@ModelAttribute("data") @Valid Data data, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "create";
        }

        if(data.getWallet()>1000){
            data.setLock("true");
        }else if(data.getWallet()<=1000) {
            data.setLock("false");
        }

        dataDAO.create(data);

        return "redirect:/data";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("data",dataDAO.index(id));

        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("data") @Valid Data data,BindingResult bindingResult ,@PathVariable("id")int id){

        if(bindingResult.hasErrors()){
            return "edit";
        }

        if(data.getWallet()>1000){
            data.setLock("true");
        }else if(data.getWallet()<=1000) {
            data.setLock("false");
        }

        dataDAO.update(id,data);

        return "redirect:/data/{id}";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        dataDAO.delete(id);

        return "redirect:/data";
    }

}
