package com.example.codingbat.Controller;

import com.example.codingbat.Dto.LanguageDto;
import com.example.codingbat.Entity.Language;
import com.example.codingbat.Service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/language")
public class LanguageController {
    @Autowired
    LanguageService languageService;

    @GetMapping
    public List<Language> getLanguage() {
        return languageService.getLanguage();
    }
    @PostMapping
    public ResponseEntity<Result> postLanguage(@RequestBody LanguageDto languageDto) {
        Result result = languageService.postLanguage(languageDto);
        if (result.getActive()) {
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.status(204).body(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> putLanguage(@PathVariable Integer id,@RequestBody LanguageDto languageDto) {
        Result result = languageService.putLanguage(id,languageDto);
        if (result.getActive()) {
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.status(204).body(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLanguage(@PathVariable Integer id)  {
        Result result = languageService.deleteLanguage(id);
        if (result.getActive()) {
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.status(204).body(result);
    }

}
