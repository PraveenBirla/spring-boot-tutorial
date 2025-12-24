package jpatutorial.jpatutorial.Controller;


import jpatutorial.jpatutorial.Entities.ProductEntity;
import jpatutorial.jpatutorial.Repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

     private final int PAGE_SIZE = 5;

    private final ProductRepository productRepository;


    public ProductController(  ProductRepository productRepository) {

        this.productRepository = productRepository;

    }

//    @GetMapping("/")
//    public List<ProductEntity> getAllProductOrderByPrice(){
//
//        return productRepository.findByOrderByPrice();
//    }

//    @GetMapping()
//    public List<ProductEntity> getAllProductOrderByPrice(@RequestParam(defaultValue = "id") String sortBY){
//
//       // return productRepository.findBy(Sort.by(Sort.Direction.DESC , sortBY , "price"));
//
//        return productRepository.findBy(Sort.by(
//                Sort.Order.desc(sortBY),
//                Sort.Order.asc("price")
//        ));
//    }

    @GetMapping()
    public List<ProductEntity> getAllProductOrderByPrice( @RequestParam(defaultValue = "") String title,
            @RequestParam(defaultValue = "id") String sortBY ,
            @RequestParam(defaultValue = "0") int PageNo){

        return productRepository.findByTitleContainingIgnoreCase(title ,
                PageRequest.of(PageNo , PAGE_SIZE , Sort.by(sortBY))) ;

//        Pageable pageable = PageRequest.of(PageNo , PAGE_SIZE , Sort.by(sortBY));
//
//        return productRepository.findAll(pageable).getContent();

    }
}
