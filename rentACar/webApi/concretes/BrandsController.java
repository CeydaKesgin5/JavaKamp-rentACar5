package kodlama.io.rentACar.webApi.concretes;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController //annotation bilgilendirme
//Spring framework bu uygulamayı derlediğinde veya çalışırken RestController i görünce burasının erişim noktası olduğunu anlıyor.
@RequestMapping("/api/brands") //bu yöntem ile iletişim kuruyor
public class BrandsController {
    private BrandService brandService;
    @Autowired //git parametrelerine bak---->brandService
    // git uygulamayı tara ---> kim bu brandService'yi implemente ediyor
    // BrandManager implemente ediyor. Onun new lenmiş halini bana ver
    // BrandManager brandManager=new BrandManager(new InMemoryBrandRepository()); anlamına geliyor
    public BrandsController(BrandService brandService){
        this.brandService=brandService;
    }
    @GetMapping("/getall") //www.kodlama.io/api/brands//getAll
    public List<GetAllBrandsResponse> getAll(){
        //IoC -->Inversion of Control -->sürekli new leme işleminden kurtarıyor//1 kere new liyor herkes onu kullanıyor
        // @Service anatasyonunu kullanarak

        return brandService.getAll();
    }
    @PostMapping("/add")
    public void add(@RequestBody() CreateBrandRequest createBrandRequest){

        this.brandService.add(createBrandRequest);
    }
}
