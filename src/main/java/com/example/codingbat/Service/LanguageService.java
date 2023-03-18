package com.example.codingbat.Service;

import com.example.codingbat.Controller.Result;
import com.example.codingbat.Dto.LanguageDto;
import com.example.codingbat.Entity.Language;
import com.example.codingbat.Repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {
    @Autowired
    LanguageRepository languageRepository;
    public List<Language> getLanguage() {
        return languageRepository.findAll();
    }

    public Result postLanguage(LanguageDto languageDto) {
        if (!languageRepository.existsByName(languageDto.getName())) {
            languageRepository.save(new Language(null, languageDto.getName()));
            return new Result("saqlandi",true);
        }
        return new Result("saqlanmadi",false);
    }

    public Result putLanguage(Integer id, LanguageDto languageDto) {
        Optional<Language> byId = languageRepository.findById(id);
        if (byId.isPresent()) {
            Language language = byId.get();
            language.setName(languageDto.getName());
            languageRepository.save(language);
            return new Result("Ozgardi",true);
        }
        return new Result("topilmadi",false);
    }

    public Result deleteLanguage(Integer id) {
        if (languageRepository.existsById(id)) {
            languageRepository.deleteById(id);
            return new Result("delete",true);
        }
        return new Result("Topilmadi",false);
    }
}
