package br.com.rcazambuja.review.model;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="review-service")
public interface ReviewsClient {
    @RequestMapping(value="/api/v1/reviews", method = RequestMethod.GET)
    public List<Review> list(@RequestParam(name="isbn", required=true) String isbn);       
}
