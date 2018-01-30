package com.mypackage.francis;

import com.helper.enums.DrugProtocolIcons;
import org.testng.annotations.Test;

public class EnumTestClass {

    @Test
    void enumTestMethod() {
        System.out.println(DrugProtocolIcons.ALLERGY.getClassReference());
        System.out.println(DrugProtocolIcons.BLACK_BOX.getClassReference());
        System.out.println(DrugProtocolIcons.DRUG_INTERACTION.getClassReference());
        System.out.println(DrugProtocolIcons.DOSE_CHECK.getClassReference());
    }


}
