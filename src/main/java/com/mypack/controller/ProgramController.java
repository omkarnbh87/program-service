package com.mypack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypack.pojo.ProgramReqRes;
import com.mypack.service.ProgramService;

@RestController
@RequestMapping("/program")
public class ProgramController {

	@Autowired
	private ProgramService programService;

	@GetMapping
	public ResponseEntity<List<ProgramReqRes>> getAllPrograms() {
		System.out.println("ProgramController.ProgramController invoked...");

		List<ProgramReqRes> response = programService.getAllPrograms();
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProgramReqRes> getProgramById(@PathVariable int id) {
		System.out.println("ProgramController.getProgramById invoked || id:" + id);

		return ResponseEntity.ok(programService.getProgramById(id));
	}

	@PostMapping
	public ResponseEntity<ProgramReqRes> createProgram(@RequestBody ProgramReqRes programReqRes) {
		System.out.println("ProgramController.createProgram invoked...");
		System.out.println("programReqRes:" + programReqRes);

		return ResponseEntity.ok(programService.createProgram(programReqRes));
	}

	@PutMapping
	public ResponseEntity<ProgramReqRes> updateProgram(@RequestBody ProgramReqRes programReqRes) {
		System.out.println("ProgramController.updateProgram invoked...");
		System.out.println("programReqRes:" + programReqRes);

		return ResponseEntity.ok(programService.updateProgram(programReqRes));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProgram(@PathVariable int id) {
		System.out.println("ProgramController.deleteProgram invoked || id:" + id);

		programService.deleteProgram(id);
		return ResponseEntity.noContent().build();
	}
}
