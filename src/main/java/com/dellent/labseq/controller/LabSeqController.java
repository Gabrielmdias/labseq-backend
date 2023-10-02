package com.dellent.labseq.controller;

import com.dellent.labseq.service.LabSeqService;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping(value = "/labseq", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "LabSeq Controller")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LabSeqController {

    private final LabSeqService labSeqService;

    public LabSeqController(LabSeqService labSeqService) {
        this.labSeqService = labSeqService;
    }

    @GetMapping(value = "/{value}")
    @ApiOperation(value = "Get result operation LabSeq", notes = "return the value of operation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "return the value of operation"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
    })
    public BigInteger getLabSeq(@PathVariable BigInteger value) {
        return labSeqService.calcLabSeq(value);
    }
}
