package com.example.takeALot.domain.usecases;

import com.example.takeALot.domain.repository.ProductsRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class GetHomePageProductsUseCase_Factory implements Factory<GetHomePageProductsUseCase> {
  private final Provider<ProductsRepository> productsRepoProvider;

  public GetHomePageProductsUseCase_Factory(Provider<ProductsRepository> productsRepoProvider) {
    this.productsRepoProvider = productsRepoProvider;
  }

  @Override
  public GetHomePageProductsUseCase get() {
    return newInstance(productsRepoProvider.get());
  }

  public static GetHomePageProductsUseCase_Factory create(
      Provider<ProductsRepository> productsRepoProvider) {
    return new GetHomePageProductsUseCase_Factory(productsRepoProvider);
  }

  public static GetHomePageProductsUseCase newInstance(ProductsRepository productsRepo) {
    return new GetHomePageProductsUseCase(productsRepo);
  }
}
