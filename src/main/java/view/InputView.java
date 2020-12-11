package view;

import subway.domain.Station;
import subway.domain.Line;
import utils.VerifyInput;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private static void bufferFlush() {
        scanner.nextLine();
    }

    public static String getFunctionSelect(List<String> choices) {
        System.out.println(OutputView.QUERY_FUNCTION_SELECT);
        try {
            String input = scanner.nextLine();
            VerifyInput.functionSelect(choices, input);
            return input;
        } catch (Exception e) {
            return getFunctionSelect(choices);
        }
    }

    public static String getRegisterStationName() {
        System.out.println(OutputView.QUERY_REGISTER_STATION_NAME);
        try {
            String input = scanner.nextLine();
            VerifyInput.lengthOfName(input);
            VerifyInput.suffixStationName(input);
            VerifyInput.duplicateStationName(input);
            return input;
        } catch (Exception e) {
            return getRegisterStationName();
        }
    }

    public static String getDeleteStationName() {
        System.out.println(OutputView.QUERY_DELETE_STATION_NAME);
        try {
            String input = scanner.nextLine();
            Station station = VerifyInput.existStationName(input);
            VerifyInput.notIncludedAnyLinesIn(station);
            return input;
        } catch (Exception e) {
            return getDeleteStationName();
        }
    }

    public static String getRegisterLineName() {
        System.out.println(OutputView.QUERY_REGISTER_LINE_NAME);
        try {
            String input = scanner.nextLine();
            VerifyInput.lengthOfName(input);
            VerifyInput.suffixLineName(input);
            VerifyInput.duplicateLineName(input);
            return input;
        } catch (Exception e) {
            return getRegisterLineName();
        }
    }

    public static String getDeleteLineName() {
        System.out.println(OutputView.QUERY_DELETE_LINE_NAME);
        try {
            String input = scanner.nextLine();
            Line line = VerifyInput.existLineName(input);
            VerifyInput.notIncludedAnyStationsIn(line);
            return input;
        } catch (Exception e) {
            return getDeleteLineName();
        }
    }

    public static String getRegisterLineNorthboundName() {
        System.out.println(OutputView.QUERY_REGISTER_LINE_NORTHBOUND_NAME);
        try {
            String input = scanner.nextLine();
            Station station = VerifyInput.existStationName(input);
            VerifyInput.haveNorthboundIn(station);
            return input;
        } catch (Exception e) {
            return getRegisterLineNorthboundName();
        }
    }

    public static String getRegisterLineSouthboundName() {
        System.out.println(OutputView.QUERY_REGISTER_LINE_SOUTHBOUND_NAME);
        try {
            String input = scanner.nextLine();
            Station station = VerifyInput.existStationName(input);
            VerifyInput.haveSouthboundIn(station);
            return input;
        } catch (Exception e) {
            return getRegisterLineSouthboundName();
        }
    }

    public static String getRegisterSectionLineName() {
        System.out.println(OutputView.QUERY_REGISTER_SECTION_LINE_NAME);
        try {
            String input = scanner.nextLine();
            VerifyInput.existLineName(input);
            return input;
        } catch (Exception e) {
            return getRegisterSectionLineName();
        }
    }

    public static String getRegisterSectionStationName() {
        System.out.println(OutputView.QUERY_REGISTER_SECTION_STATION_NAME);
        try {
            String input = scanner.nextLine();
            VerifyInput.existStationName(input);
            return input;
        } catch (Exception e) {
            return getRegisterSectionStationName();
        }
    }

    public static int getRegisterSectionOrder(Line line) {
        System.out.println(OutputView.QUERY_REGISTER_SECTION_ORDER);
        try {
            int input = scanner.nextInt();
            bufferFlush();
            VerifyInput.sectionOrderIn(line, input);
            return input;
        } catch (InputMismatchException ime) {
            bufferFlush();
            OutputView.printError(OutputView.MESSAGE_ERROR_NOT_POSITIVE_INTEGER);
            return getRegisterSectionOrder(line);
        } catch (Exception e) {
            return getRegisterSectionOrder(line);
        }
    }

    public static String getDeleteSectionLineName() {
        System.out.println(OutputView.QUERY_DELETE_SECTION_LINE_NAME);
        try {
            String input = scanner.nextLine();
            Line line = VerifyInput.existLineName(input);
            return input;
        } catch (Exception e) {
            return getDeleteSectionLineName();
        }
    }

    public static String getDeleteSectionStationName(Line line) {
        System.out.println(OutputView.QUERY_DELETE_SECTION_STATION_NAME);
        try {
            String input = scanner.nextLine();
            VerifyInput.existStationName(line, input);
            return input;
        } catch (Exception e) {
            return getDeleteSectionStationName(line);
        }
    }

}
