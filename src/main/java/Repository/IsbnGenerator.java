/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import java.util.Random;

/**
 *
 * @author DELL_PC
 */
public class IsbnGenerator implements NumberGenerator{

    @Override
    public String generateNumber() {
        return "13-84356" + Math.abs(new Random() . nextInt());
    }
    
}
