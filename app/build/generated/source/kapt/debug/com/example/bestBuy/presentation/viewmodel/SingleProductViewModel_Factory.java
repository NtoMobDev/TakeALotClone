package com.example.bestBuy.presentation.viewmodel;

import androidx.lifecycle.SavedStateHandle;
import com.example.bestBuy.domain.usecases.GetSingleProductUseCase;
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
public final class SingleProductViewModel_Factory implements Factory<SingleProductViewModel> {
  private final Provider<GetSingleProductUseCase> getSingleProductUseCaseProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  public SingleProductViewModel_Factory(
      Provider<GetSingleProductUseCase> getSingleProductUseCaseProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    this.getSingleProductUseCaseProvider = getSingleProductUseCaseProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public SingleProductViewModel get() {
    return newInstance(getSingleProductUseCaseProvider.get(), savedStateHandleProvider.get());
  }

  public static SingleProductViewModel_Factory create(
      Provider<GetSingleProductUseCase> getSingleProductUseCaseProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    return new SingleProductViewModel_Factory(getSingleProductUseCaseProvider, savedStateHandleProvider);
  }

  public static SingleProductViewModel newInstance(GetSingleProductUseCase getSingleProductUseCase,
      SavedStateHandle savedStateHandle) {
    return new SingleProductViewModel(getSingleProductUseCase, savedStateHandle);
  }
}
