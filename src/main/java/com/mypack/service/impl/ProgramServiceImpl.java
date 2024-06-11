package com.mypack.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mypack.constants.ErrorCodeEnum;
import com.mypack.entities.Program;
import com.mypack.exception.ProgramExeption;
import com.mypack.pojo.ProgramReqRes;
import com.mypack.repository.ProgramRepository;
import com.mypack.service.ProgramService;

@Service
public class ProgramServiceImpl implements ProgramService {

	@Autowired
	private ProgramRepository programRepository;

	@Autowired 
	private ModelMapper modelMapper;

	@Override
	public ProgramReqRes createProgram(ProgramReqRes programReqRes) {
		System.out.println("ProgramServiceImpl.createProgram invoked...");

		//convert pojo to entity
		Program program = modelMapper.map(programReqRes, Program.class);

		System.out.println("After conversion program:" + program);

		Program programDb = programRepository.save(program);
		if(programDb != null) {
			System.out.println("Program saved successfully in db");
			System.out.println("programDb:" + programDb);
		}
		else
			System.out.println("Program not saved in db something went wrong");

		programReqRes = modelMapper.map(programDb, ProgramReqRes.class);

		return programReqRes;
	}

	@Override
	public ProgramReqRes updateProgram(ProgramReqRes programReqRes) {
		System.out.println("ProgramServiceImpl.updateProgram invoked...");

		Program program = modelMapper.map(programReqRes, Program.class);

		Program programDb = programRepository.getProgramById(program.getId());

		if(programDb == null) {
			System.out.println("Program not found with provided id");

			throw new ProgramExeption(HttpStatus.BAD_REQUEST,
					ErrorCodeEnum.PAYMENT_NOT_FOUND.getErrorCode(),
					ErrorCodeEnum.PAYMENT_NOT_FOUND.getErrorMessage());
		}

		if (program.getName() != null) {
			programDb.setName(program.getName());
		}
		if (program.getPrice() != null) {
			programDb.setPrice(program.getPrice());
		}
		if (program.getDomain() != null) {
			programDb.setDomain(program.getDomain());
		}
		if (program.getProgramType() != null) {
			programDb.setProgramType(program.getProgramType());
		}
		if (program.getRegistrations() != null) {
			programDb.setRegistrations(program.getRegistrations());
		}
		if (program.getDescription() != null) {
			programDb.setDescription(program.getDescription());
		}
		if (program.getPlacementAssurance() != null) {
			programDb.setPlacementAssurance(program.getPlacementAssurance());
		}
		if (program.getImageUrl() != null) {
			programDb.setImageUrl(program.getImageUrl());
		}
		if (program.getUniversityName() != null) {
			programDb.setUniversityName(program.getUniversityName());
		}
		if (program.getFacultyProfile() != null) {
			programDb.setFacultyProfile(program.getFacultyProfile());
		}
		if (program.getLearningHoursAndDuration() != null) {
			programDb.setLearningHoursAndDuration(program.getLearningHoursAndDuration());
		}
		if (program.getCertificateOrDiploma() != null) {
			programDb.setCertificateOrDiploma(program.getCertificateOrDiploma());
		}
		if (program.getEligibilityCriteria() != null) {
			programDb.setEligibilityCriteria(program.getEligibilityCriteria());
		}

		System.out.println("Updated program is programDb:" + programDb);

		programRepository.save(programDb);

		programReqRes = modelMapper.map(programDb, ProgramReqRes.class);

		return programReqRes;
	}

	@Override
	public ProgramReqRes getProgramById(int id) {
		System.out.println("ProgramServiceImpl.getProgramById invoked...");

		Program program = programRepository.getProgramById(id);

		if(program == null) {
			System.out.println("Program not found in db with provided id");
			throw new ProgramExeption(HttpStatus.BAD_REQUEST,
					ErrorCodeEnum.PAYMENT_NOT_FOUND.getErrorCode(),
					ErrorCodeEnum.PAYMENT_NOT_FOUND.getErrorMessage());
		}

		System.out.println("Successfully got the program from db with providede id");
		System.out.println("program:" + program);

		ProgramReqRes programReqRes = modelMapper.map(program, ProgramReqRes.class);

		return programReqRes;
	}

	@Override
	public List<ProgramReqRes> getAllPrograms() {
		System.out.println("ProgramServiceImpl.getAllPrograms invoked...");

		List<Program> programs = programRepository.findAll();

		if(programs == null) {
			System.out.println("Dont have any program in db!!!");

			return null;
		}

		System.out.println("Get all programs from db || programs:" + programs);

		List<ProgramReqRes> programReqResList = new ArrayList<>();
		for (Program program : programs) {
			ProgramReqRes programReqRes = modelMapper.map(program, ProgramReqRes.class);
			programReqResList.add(programReqRes);
		}
		return programReqResList;
	}

	@Override
	public void deleteProgram(int id) {
		System.out.println("ProgramServiceImpl.deleteProgram invoked...");

		Program program = programRepository.getProgramById(id);

		if(program == null) {
			System.out.println("Program not found for provided id");
			throw new ProgramExeption(HttpStatus.BAD_REQUEST,
					ErrorCodeEnum.PAYMENT_NOT_FOUND.getErrorCode(),
					ErrorCodeEnum.PAYMENT_NOT_FOUND.getErrorMessage());
		}

		System.out.println("Deleted program:" + program);
		programRepository.deleteById(id);



	}

}
