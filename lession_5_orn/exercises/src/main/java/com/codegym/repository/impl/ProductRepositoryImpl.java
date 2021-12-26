package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements IProductRepository {

    @Override
    public List<Product> findAll() {
        List<Product> productList = BaseRepository.entityManager
                .createQuery("select p from products as p", Product.class).getResultList();
        return productList;
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        Product product1 = new Product();
        product1.setId(product.getId());
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setDescription(product.getDescription());
        product1.setPublish(product.getPublish());
        BaseRepository.entityManager.persist(product1);
        entityTransaction.commit();
    }

    @Override
    public Product findById(int id) {
        Product product = BaseRepository.entityManager
                .createQuery("select p from products p where p.id = :id", Product.class)
                .setParameter("id", id)
                .getSingleResult();
        return product;
    }

    @Override
    public void update(int id, Product product) {
        try {
            EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
            entityTransaction.begin();
            Product product1 = BaseRepository.entityManager
                    .createQuery("select p from products p where p.id = :id", Product.class)
                    .setParameter("id", id)
                    .getSingleResult();
            product1.setId(product.getId());
            product1.setName(product.getName());
            product1.setPrice(product.getPrice());
            product1.setDescription(product.getDescription());
            product1.setPublish(product.getPublish());
            BaseRepository.entityManager.persist(product1);
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {

        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        Product product1 = null;
        product1 = findById(id);
        BaseRepository.entityManager.remove(product1);
        entityTransaction.commit();
    }
}
