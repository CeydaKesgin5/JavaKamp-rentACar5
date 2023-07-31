package kodlama.io.rentACar.business.concretes;

import jakarta.websocket.server.ServerEndpoint;
import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.stereotype.Service;

import java.lang.management.GarbageCollectorMXBean;
import java.util.ArrayList;
import java.util.List;
@Service //BU SINIF BİR BUSNESS NESNESİDİR
public class BrandManager implements BrandService {
   private BrandRepository brandRepository;

    public BrandManager(BrandRepository brandRepository) {
        super();
        this.brandRepository = brandRepository;
    }

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand>brands=brandRepository.findAll();//içinde markaların olduğu liste
        List<GetAllBrandsResponse> brandsResponse=new ArrayList<GetAllBrandsResponse>();//boş liste

        //mapping işlemi
        for (Brand brand:brands){//ana listeyi dolaştık
            GetAllBrandsResponse responseItem=new GetAllBrandsResponse();
            responseItem.setId(brand.getId());
            responseItem.setName(brand.getName());

            brandsResponse.add(responseItem);

        }
        return brandsResponse;
        //iş kuralları
        //findAll JpaRepository içinden gelen bir fonksiyon
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        Brand brand=new Brand();
        brand.setName(createBrandRequest.getName());
        this.brandRepository.save(brand);
        //veri tabanı brand den alınıyor
    }
}
