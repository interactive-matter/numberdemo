package com.example.numberdemo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convert")
@Getter
@RequiredArgsConstructor
@Slf4j
public class ConversionController {

    private final Converter converter;

    @GetMapping("/{in}-to-{out}/{value}")
    public ResponseEntity<String> connvert(@PathVariable String in, @PathVariable String out, @PathVariable String value) {
        try {
            //TODO with this patter we can even use some caching header settings
            return new ResponseEntity<>(
                    converter.convert(in,out, value),
                    HttpStatus.OK
            );
        } catch (IllegalArgumentException e) {
            String message = String.format("Unable to convert %s reading as %s to %s: %s", value, in, out, e.getMessage());
            log.info(message);
            log.debug("original exception ",e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            String message = String.format("Error converting %s reading as %s to %s", value, in, out);
            log.info(message);
            log.debug("original exception ",e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
