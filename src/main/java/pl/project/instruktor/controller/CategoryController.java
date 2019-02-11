package pl.project.instruktor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.project.instruktor.model.Category;
import pl.project.instruktor.repository.CategoryRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @ModelAttribute("mainCategories")
    public List<Category> mainCategories() {
        return categoryRepository.findMainCategories();
    }

    @GetMapping("")
    public String categories(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("allCategories", categories);
        return "category";
    }

    @GetMapping("/add")
    public String addCategory(@ModelAttribute Category category) {
        return "categoryAdd";
    }

    @PostMapping("/add")
    public String addCategorySuccess(@Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "categoryAdd";
        }
        categoryRepository.save(category);
        return "redirect:/category";
    }

    @GetMapping("/edit/{id}")
    public String editCategory(@PathVariable long id, Model model) {
        Category categoryToEdit = categoryRepository.getOne(id);
        categoryToEdit.setName(categoryToEdit.getName());
        categoryToEdit.setParent(categoryToEdit.getParent());
        model.addAttribute("category", categoryToEdit);
        return "categoryEdit";
    }

    @PostMapping("/edit/{id}")
    public String editCategorySuccess(@Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "categoryEdit";
        }
        categoryRepository.save(category);
        return "redirect:/category";
    }

    @GetMapping("/delete/{id}")
    public String removeCategory(@PathVariable long id, Model model) {
        Category categoryToRemove = categoryRepository.getOne(id);
        model.addAttribute("categoryToRemove", categoryToRemove);
        return "categoryDelete";
    }

    @PostMapping("/delete/{id}")
    public String removeCategorySuccess(@PathVariable long id) {
        Category categoryToRemove = categoryRepository.getOne(id);
        categoryRepository.delete(categoryToRemove);
        return "redirect:/category";
    }
}
