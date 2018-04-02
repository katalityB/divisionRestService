package com.surpreso.spring_mongo;

import net.minidev.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DivisionController {

    @RequestMapping(value = "/division", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST, consumes="application/json")
    public ResponseEntity<JSONObject> division (
            @RequestParam(value="dividend") String dividend,
            @RequestParam(value="divisor") String divisor
    ) {
        dividend = dividend.replaceAll(",", ".");
        divisor = divisor.replaceAll(",", ".");
        if(Double.parseDouble(divisor) == 0.0){
            throw new NumberFormatException("Divisor should not be zero.");
        }
        JSONObject response = new JSONObject();
        DivisionModel division = new DivisionModel(dividend, divisor);
        response.put("result", division.getResultStr());
        return ResponseEntity
                .ok()
                .body(response);
    }
}
