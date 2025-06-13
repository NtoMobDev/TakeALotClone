package com.example.bestBuy.presentation.viewmodel;

import com.example.bestBuy.domain.usecases.GetCategoriesUseCase;
import com.example.bestBuy.domain.usecases.GetHomePageProductsUseCase;
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
public final class ProductsViewModel_Factory implements Factory<ProductsViewModel> {
  private final Provider<GetCategoriesUseCase> getCategoriesUseCaseProvider;

  private final Provider<GetHomePageProductsUseCase> getHomePageProductsUseCaseProvider;

  public ProductsViewModel_Factory(Provider<GetCategoriesUseCase> getCategoriesUseCaseProvider,
      Provider<GetHomePageProductsUseCase> getHomePageProductsUseCaseProvider) {
    this.getCategoriesUseCaseProvider = getCategoriesUseCaseProvider;
    this.getHomePageProductsUseCaseProvider = getHomePageProductsUseCaseProvider;
  }

  @Override
  public ProductsViewModel get() {
    return newInstance(getCategoriesUseCaseProvider.get(), getHomePageProductsUseCaseProvider.get());
  }

  public static ProductsViewModel_Factory create(
      Provider<GetCategoriesUseCase> getCategoriesUseCaseProvider,
      Provider<GetHomePageProductsUseCase> getHomePageProductsUseCaseProvider) {
    return new ProductsViewModel_Factory(getCategoriesUseCaseProvider, getHomePageProductsUseCaseProvider);
  }

  public static ProductsViewModel newInstance(GetCategoriesUseCase getCategoriesUseCase,
      GetHomePageProductsUseCase getHomePageProductsUseCase) {
    return new ProductsViewModel(getCategoriesUseCase, getHomePageProductsUseCase);
  }
}
