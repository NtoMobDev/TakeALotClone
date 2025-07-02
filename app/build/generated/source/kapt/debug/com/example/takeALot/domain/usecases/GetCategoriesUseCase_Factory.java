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
public final class GetCategoriesUseCase_Factory implements Factory<GetCategoriesUseCase> {
  private final Provider<ProductsRepository> productsRepoProvider;

  public GetCategoriesUseCase_Factory(Provider<ProductsRepository> productsRepoProvider) {
    this.productsRepoProvider = productsRepoProvider;
  }

  @Override
  public GetCategoriesUseCase get() {
    return newInstance(productsRepoProvider.get());
  }

  public static GetCategoriesUseCase_Factory create(
      Provider<ProductsRepository> productsRepoProvider) {
    return new GetCategoriesUseCase_Factory(productsRepoProvider);
  }

  public static GetCategoriesUseCase newInstance(ProductsRepository productsRepo) {
    return new GetCategoriesUseCase(productsRepo);
  }
}
