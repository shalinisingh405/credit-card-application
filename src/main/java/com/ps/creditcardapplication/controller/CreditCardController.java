package com.ps.creditcardapplication.controller;

import com.ps.creditcardapplication.entity.CreditCard;
import com.ps.creditcardapplication.request.CreditCardRequest;
import com.ps.creditcardapplication.service.CreditCardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "CreditCards REST Controller")
@RestController
@RequestMapping("/api")
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

    @ApiOperation(value = "Add a Credit Card")
    @PostMapping("/creditCards")
    public ResponseEntity addCreditCard(@Valid @RequestBody CreditCardRequest creditCardRequest){

       return new ResponseEntity<>(creditCardService.add(creditCardRequest), HttpStatus.CREATED);
    }

    @ApiOperation(value = "List all CreditCards", response = Iterable.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
                            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
                            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
                            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
    @GetMapping("/creditCards")
    public ResponseEntity<List<CreditCard>> getAllCreditCards(){
        return new ResponseEntity<List<CreditCard>>(creditCardService.getAll(), HttpStatus.OK);
    }
}
