package com.mypackage.francis;

import com.helper.enums.DrugProtocolIcons;
import org.testng.annotations.Test;

public class EnumTestClass {

    @Test
    void enumTestMethod() {
        System.out.println(DrugProtocolIcons.Allergy.getClassReference());
        System.out.println(DrugProtocolIcons.BlackBox.getClassReference());
        System.out.println(DrugProtocolIcons.DrugInteraction.getClassReference());
        System.out.println(DrugProtocolIcons.DoseCheck.getClassReference());
    }


}
