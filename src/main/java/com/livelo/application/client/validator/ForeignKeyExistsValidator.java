package com.livelo.application.client.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.data.repository.CrudRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class ForeignKeyExistsValidator implements ConstraintValidator<ForeignExists, Integer> {

    private final ApplicationContext applicationContext;

    private CrudRepository repository;

    @Override
    public void initialize(final ForeignExists constraint) {
        String[] beanNamesForType = applicationContext
                .getBeanNamesForType(ResolvableType.forClassWithGenerics(CrudRepository.class, constraint.entity(), Integer.class));

        repository = (CrudRepository) applicationContext.getBean(beanNamesForType[0]);
    }

    public boolean isValid(final Integer id, final ConstraintValidatorContext context) {
        return repository.existsById(id);
    }
}
