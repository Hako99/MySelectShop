package com.sparta.spring0402myselectshop.repository;

import com.sparta.spring0402myselectshop.entity.Folder;
import com.sparta.spring0402myselectshop.entity.Product;
import com.sparta.spring0402myselectshop.entity.ProductFolder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductFolderRepository extends JpaRepository<ProductFolder, Long> {
    Optional<ProductFolder> findByProductAndFolder(Product product, Folder folder);
}