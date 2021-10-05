package team.java.auction.house.service;

import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.java.auction.house.domain.ProductEntity;
import team.java.auction.house.domain.QProductEntity;
import team.java.auction.house.repository.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @PersistenceContext
    private EntityManager em;

    public List<ProductEntity> findProductsByIds(List<Long> productIds) {
        JPAQuery<ProductEntity> query = new JPAQuery<>(em);
        QProductEntity product = QProductEntity.productEntity;
        return query.select(product).from(product)
                .where(product.productId.in(productIds))
                .fetch();
    }

    public Optional<ProductEntity> findProductById(Long id) {
        return productRepository.findById(id);
    }

    public void saveProduct(ProductEntity product) {
        productRepository.save(product);
    }
}
