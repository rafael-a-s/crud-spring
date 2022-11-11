package com.rafael.crud.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.crud.model.Course;
import com.rafael.crud.repository.CourseRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {


    private final CourseRepository repo;

    
    @GetMapping //Associar com o DoGet do servlet
    public @ResponseBody List<Course> list(){
        return repo.findAll();
    }

    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Course create(@RequestBody Course course){
        return repo.save(course);
        //return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(course));
    }
    
    @GetMapping("/{id}") //Faz ref o id que vai ser passado na requisicao
    public ResponseEntity<Course> findById(@PathVariable("id") Long id){//pathvariable pega esse id que vem no corpo e atribui ao long id/ se os nomes fossem diferente usa se esse tipo id que esta sendo passadp por parentese
        return repo.findById(id)
        .map(registro -> ResponseEntity.ok().body(registro))
        .orElse(ResponseEntity.notFound().build());
        //Usando um pouco da linguagem funcional do java. O retorno é um optional, pois o id pode ou nao existir 
        //Nesse caso retorna um ResponseEntity do tipo do obj. 
        //no map vc cria um registo que se estiver ok vc manda ele no corpo da requisicao.
        //Caso caia no orElse vc manda um notFound e build, ou seja, não encontrou nada .
    }
}
