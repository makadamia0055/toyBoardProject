package com.ppl.toyboard.root.common;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= "classpath:test-Business-layer.xml")
class BoardCRUDTest {

}
