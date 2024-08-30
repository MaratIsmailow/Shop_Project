package ait.shop.controller;

import ait.shop.exception_handling.Response;
import ait.shop.exceptions.FirstTestException;
import ait.shop.model.dto.ProductDTO;
import ait.shop.service.interfaces.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

// http://localhost:8080/products
    /*
    http://example.com/home
    http://example.com/about
    http://example.com/api/products
    http://example.com/api/customer

Сохранение нового продукта
POST /products

Получить продукт по id
GET    /products/id
GET    /products

Обновление PUT    /products/id
Удаление DELETE /products/id

     */




@RestController
@RequestMapping("/products")
@Tag(name = "Product controller", description = "Controller for operations with products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // /products

    @Operation(summary = "Create product", tags = { "Product" }, description = "Add new product.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDTO.class)),
                            @Content(mediaType = "application/xml", schema = @Schema(implementation = ProductDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid username supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content) })

    @PostMapping
    public ProductDTO saveProduct(@Valid @RequestBody ProductDTO productDTO) {
        // TODO обращаемся к сервису для сохранения продукты
        return productService.saveProduct(productDTO);
    }

//    // GET /products?id=3
//    @GetMapping
//    public Product getById(@RequestParam("id") long id) {
//        // TODO обращаемся к сервису для получения продукта по id
//        return null;
//    }


    // GET /products/{id} - переменная пути
    // GET /products/1234/45 - переменная пути

    @Operation(summary = "Get product by id", tags = { "Product" }, description = "Find product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDTO.class)), @Content(mediaType = "application/xml", schema = @Schema(implementation = ProductDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid username supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content) })

    @GetMapping("/{product_id}")
    public ProductDTO getById(
            @Parameter(description = "The id that needs to be fetched. ", required = true) @PathVariable("product_id") long id) {
        // Проверяем, если ID равен 10, выбрасываем исключение
        // ТАК делать НЕЛЬЗЯ! Обработка, бизнес-логика должна быть ТОЛЬКЛ в сервисах!!!
//        if (id == 10) {
//            throw new FirstTestException("ID cannot be 10");
//        }
        return productService.getById(id);
    }

    // PUT -> /products/id и в теле запроса - объект Json с теми полями, которые мы хотим поменять
    @PutMapping("/{id}")
    public ProductDTO updateProduct (@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        return productService.updateProduct(id, productDTO);
    }

    // DELETE -> /products/id
    @DeleteMapping("/{id}")
    public ProductDTO remove(@PathVariable Long id) {
        return productService.remove(id);
    }


    @GetMapping
    public List<ProductDTO> getAll() {
        return productService.getAll();
    }

//    // DELETE /products?id=1&title=Banana
//    @DeleteMapping
//    public Product removeUniversal(@RequestParam(required = false) Long id,
//                                   @RequestParam(required = false) String title) {
//        if (id != null) {
//            return productService.remove(id);
//        } else if (title != null) {
//            return productService.removeByTitle(title);
//        }
//        return null;
//    }


    // DELETE /products/by-title?title=Banana
    @DeleteMapping("/by-title")
    public ProductDTO removeByTitle(@RequestParam String title) {
        return productService.removeByTitle(title);
    }

    // PUT /products/restore/88
    @PutMapping("/restore/{id}")
    public ProductDTO restoreById(@PathVariable Long id) {
        return productService.restoreById(id);
    }

    // GET /products/count
    @GetMapping("/count")
    public long getProductsCount() {
        return productService.getProductsCount();
    }

    @GetMapping("/total-price")
    public BigDecimal getTotalPrice() {
        return productService.getTotalPrice();
    }

    @GetMapping("/average-price")
    public BigDecimal getAveragePrice() {
        return productService.getAveragePrice();
    }


    @ExceptionHandler(FirstTestException.class)
    public ResponseEntity<Response> handleException(FirstTestException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}