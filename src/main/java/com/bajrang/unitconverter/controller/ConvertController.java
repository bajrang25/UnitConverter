package com.bajrang.unitconverter.controller;

import com.bajrang.unitconverter.dto.ConvertRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/convert")
public class ConvertController {

    @PostMapping
    public Map<String, Double> convert(@RequestBody ConvertRequest request) {

        double result = 0;

        switch (request.getCategory()) {

            case "length":
                if (request.getFromUnit().equals("meter") &&
                        request.getToUnit().equals("kilometer")) {
                    result = request.getValue() / 1000;
                } else if (request.getFromUnit().equals("kilometer") &&
                        request.getToUnit().equals("meter")) {
                    result = request.getValue() * 1000;
                }
                break;

            case "weight":
                if (request.getFromUnit().equals("gram") &&
                        request.getToUnit().equals("kilogram")) {
                    result = request.getValue() / 1000;
                } else if (request.getFromUnit().equals("kilogram") &&
                        request.getToUnit().equals("gram")) {
                    result = request.getValue() * 1000;
                }
                break;

            case "temperature":
                if (request.getFromUnit().equals("celsius") &&
                        request.getToUnit().equals("fahrenheit")) {
                    result = (request.getValue() * 9/5) + 32;
                } else if (request.getFromUnit().equals("fahrenheit") &&
                        request.getToUnit().equals("celsius")) {
                    result = (request.getValue() - 32) * 5/9;
                }
                break;
        }

        return Map.of("result", result);
    }
}
