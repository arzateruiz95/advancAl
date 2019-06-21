package com.advance.util

import spock.lang.Specification

class ReadFileUtilSpec extends Specification {
    private ReadFileUtil readFileUtil

    void setup() {
    }


    void "Validar lista de archivo"() {
        given:
        readFileUtil = new ReadFileUtil(fileName)
        when:
        List result = readFileUtil.extractFile()
        then:
        !result.isEmpty()
        where:
        fileName = 'C:\\Users\\luis.arzate\\Downloads\\input\\input00.txt'
    }

    void "Validar string line"() {
        given:
        readFileUtil = new ReadFileUtil(fileName)
        when:
        String result = readFileUtil.extractString(line)
        then:
        result == '100 100 50 40 40 20 10'
        where:
        fileName = 'C:\\Users\\luis.arzate\\Downloads\\input\\input00.txt'
        and:
        line = 1
    }

    void "Validar integer line"() {
        given:
        readFileUtil = new ReadFileUtil(fileName)
        when:
        Integer result = readFileUtil.extractInteger(line)
        then:
        result == 4
        where:
        fileName = 'C:\\Users\\luis.arzate\\Downloads\\input\\input00.txt'
        and:
        line = 2
    }

    void "Validar Array String"() {
        given:
        readFileUtil = new ReadFileUtil(fileName)
        when:
        String[] result = readFileUtil.extractStringArray(line)
        then:
        result.length != 0
        and:
        result == ['100', '100', '50', '40', '40', '20', '10']
        where:
        fileName = 'C:\\Users\\luis.arzate\\Downloads\\input\\input00.txt'
        and:
        line = 1
    }

    void "Validar Array Number"() {
        given:
        readFileUtil = new ReadFileUtil(fileName)
        when:
        Integer[] result = readFileUtil.extractNumberArray(line, Integer.class)
        then:
        result.length != 0
        and:
        result == [100, 100, 50, 40, 40, 20, 10]
        where:
        fileName = 'C:\\Users\\luis.arzate\\Downloads\\input\\input00.txt'
        and:
        line = 1
    }

    void "Validar Square Number"() {
        given:
        readFileUtil = new ReadFileUtil(fileName)
        when:
        Integer[][] result = readFileUtil.extractNumberSquare(Integer.class)
        then:
        result.length != 0
        and:
        result == [[4,9,2],[3,5,7],[8,1,5]]
        where:
        fileName = 'C:\\Users\\luis.arzate\\Documents\\courses\\hackeRank\\magic-square-forming-testcases\\input\\input00.txt'
        and:
        line = 1
    }
}
