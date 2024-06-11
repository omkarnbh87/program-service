package com.mypack.service;

import java.util.List;

import com.mypack.pojo.ProgramReqRes;

public interface ProgramService {

	ProgramReqRes createProgram(ProgramReqRes programReqRes);

	ProgramReqRes updateProgram(ProgramReqRes programReqRes);

	ProgramReqRes getProgramById(int id);

	List<ProgramReqRes> getAllPrograms();

	void deleteProgram(int id);

}
