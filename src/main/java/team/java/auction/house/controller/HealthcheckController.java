package team.java.auction.house.controller;


import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RestController
class HealthcheckController {

    @GetMapping(value = "/healthcheck")

    public Res healthcheck(@RequestParam(name = "format") String format) {
        if (format.equals("short")) {
            return Res.ResponseBuilder.builder().status("OK").build();
        } else if (format.equals("full")) {
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-ddThh:mm:ssZ");
            String strDate = dateFormat.format(date);
            return Res.ResponseBuilder.builder().status("OK").currentTime(strDate).build();
        }
        return Res.ResponseBuilder.builder().status("400").build();
    }

    @PutMapping(value = "/healthcheck")
    public int healthcheckPut() {
        return Response.SC_METHOD_NOT_ALLOWED;
    }

    @PostMapping(value = "/healthcheck")

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public Res healthcheckPost() {
        return Res.ResponseBuilder.builder().status("405").build();
    }


    @DeleteMapping(value = "/healthcheck")
    public Res healthcheckDelete() {
        return Res.ResponseBuilder.builder().status("405").build();
    }
}


class Res {
    private String status;
    private String currentTime;

    static final class ResponseBuilder {

        private String status;
        private String currentTime;

        public static ResponseBuilder builder() {
            return new ResponseBuilder();
        }

        public ResponseBuilder status(String status) {
            this.status = status;
            return this;
        }

        public ResponseBuilder currentTime(String currentTime) {
            this.currentTime = currentTime;
            return this;
        }

        public Res build() {

            Res response = new Res();
            response.status = this.status;
            response.currentTime = this.currentTime;
            return response;
        }
    }
}

