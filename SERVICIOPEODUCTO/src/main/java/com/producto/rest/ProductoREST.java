package com.producto.rest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.producto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import com.producto.modelo.producto;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import java.net.URI;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;


@CrossOrigin
@RestController
@RequestMapping("/producto/")
public class ProductoREST {

	@Autowired
	private ProductoService productoService;
	
	@GetMapping
	private ResponseEntity<List<producto>> getAllPersonas (){
		return ResponseEntity.ok(productoService.findAll());
	}
	
	@PostMapping
	private ResponseEntity<producto> savePersona (@RequestBody producto producto){
		try {
			producto productoGuardado = productoService.save(producto);		
		return ResponseEntity.created(new URI("/personas/"+productoGuardado.getId())).body(productoGuardado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping (value = "delete/{id}")
	private ResponseEntity<Boolean> deletePersona (@PathVariable ("id") Long id){
		productoService.deleteById(id);
		return ResponseEntity.ok(!(productoService.findById(id)!=null));
		
	}
	
}
