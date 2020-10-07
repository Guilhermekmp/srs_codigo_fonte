package com.basis.srs.web.rest;

import com.basis.srs.builder.ClienteBuilder;
import com.basis.srs.util.IntTestComum;
import lombok.RequiredArgsConstructor;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@Transactional
@RequiredArgsConstructor
public class ClienteRecursoIT extends IntTestComum {

    private final ClienteBuilder clienteBuilder;

}
