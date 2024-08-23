package com.jsp.Crud_SpringBoot.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.jsp.Crud_SpringBoot.dto.Student;
import com.jsp.Crud_SpringBoot.repository.StudentRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MyController {
	
	@Autowired
	StudentRepository repository;
	
	@GetMapping("/")
	public String loadMain(ModelMap map) {
		
		List<Student> students =repository.findAll();
		if(students.isEmpty())
		{
			map.put("failure", "Record Not Found");
			return "main.html";
		}
		else
		{
			map.put("list", students);
			return "main.html";
		}	
		
	}
	
	@GetMapping("/insert")
	public String loadInsert(ModelMap map) {
		map.put("insert", "insert");
		return loadMain(map);
	}
	
	@PostMapping("/insert")
	public String insert(Student student, ModelMap map)
	{
		repository.save(student);
		map.put("success", "Record saved");
		return loadMain(map);
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, ModelMap map) {
		repository.deleteById(id);
		map.put("success", "Record Deleted...");
		return loadMain(map);
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, ModelMap map) {
		Student student=repository.findById(id).orElseThrow();
		map.put("student", student);
		map.put("update", "update");
		return loadMain(map);
	}
	
	@PostMapping("/update")
	public String update(Student student,ModelMap map) {
		repository.save(student);
		map.put("success", "Record updated...");
		return loadMain(map) ;
	}
	
	@GetMapping("/fetch")
	public String fetch(ModelMap map)
	{
		map.put("fetch", "fetch");
		return loadMain(map);
		
	}
	
	@GetMapping("/fetch/{field}")
	public String showField(@PathVariable String field, ModelMap map)
	{
		map.put("field", field);
		return loadMain(map);
	}
	
	@PostMapping("/fetch/name")
	public String fetchByName(@RequestParam String name, ModelMap map)
	{
		List<Student> list=repository.findByName(name);
		if(list.isEmpty())
		{
			map.put("failure", "Record Not Found");
			return "main.html";
		}
		else
		{
			map.put("list", list);
			return "main.html";
		}	
	}
	
	
	@PostMapping("/fetch/mobile")
	public String fetchByMobile(@RequestParam Long mobile, ModelMap map)
	{
		List<Student> list=repository.findByMobile(mobile);
		if(list.isEmpty())
		{
			map.put("failure", "Record Not Found");
			return "main.html";
		}
		else
		{
			map.put("list", list);
			return "main.html";
		}	
	}
	
	@PostMapping("/fetch/gender")
	public String fetchByGender(@RequestParam String gender, ModelMap map)
	{
		List<Student> list=repository.findByGender(gender);
		if(list.isEmpty())
		{
			map.put("failure", "Record Not Found");
			return "main.html";
		}
		else
		{
			map.put("list", list);
			return "main.html";
		}	
	}
	
	@PostMapping("/fetch/percentage")
	public String fetchByName(@RequestParam double percentage, ModelMap map)
	{
		List<Student> list = repository.findAll().stream().filter(student -> student.getPercentage() >= percentage)
				.collect(Collectors.toList());
		
				if(list.isEmpty())
		{
			map.put("failure", "Record Not Found");
			return "main.html";
		}
		else
		{
			map.put("list", list);
			return "main.html";
		}	
	}
	
}
