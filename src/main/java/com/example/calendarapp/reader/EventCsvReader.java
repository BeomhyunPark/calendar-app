package com.example.calendarapp.reader;

import com.example.calendarapp.event.Meeting;
import com.example.calendarapp.event.NoDisturbance;
import com.example.calendarapp.event.OutOfOffice;
import com.example.calendarapp.event.Todo;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class EventCsvReader {

    private final RawCsvReader rawCsvReader;

    public EventCsvReader(RawCsvReader rawCsvReader) {
        this.rawCsvReader = rawCsvReader;
    }

    public List<Meeting> readMeetings(String path) throws IOException {
        List<Meeting> result = new ArrayList<>();

        // 데이터를 읽는 부분
        List<String[]> read = rawCsvReader.readAll(path);
        for (int i = 0; i < read.size(); i++) {
            if (skipHeader(i)){
                continue;
            }

            String[] each = read.get(i);

            // Meeting 으로 변환 부분
            result.add(
                    new Meeting(
                            Integer.parseInt(each[0]),
                            each[2],
                            ZonedDateTime.of(LocalDateTime.parse(
                                    each[6],
                                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                            ),
                                    ZoneId.of("Asia/Seoul")),
                            ZonedDateTime.of(LocalDateTime.parse(
                                            each[7],
                                            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                                    ),
                                    ZoneId.of("Asia/Seoul")),
                            new HashSet<>(Arrays.asList(each[3].split(","))),
                            each[4],
                            each[5]
                    )
            );
        }





        return result;
    }

    public List<NoDisturbance> readNoDisturbance(String path) throws IOException {
        List<NoDisturbance> result = new ArrayList<>();

        // 데이터를 읽는 부분
        List<String[]> read = rawCsvReader.readAll(path);
        for (int i = 0; i < read.size(); i++) {
            if (skipHeader(i)){
                continue;
            }

            String[] each = read.get(i);

            // Disturbance 로 변환 부분
            result.add(
                    new NoDisturbance(
                            Integer.parseInt(each[0]),
                            each[2],
                            ZonedDateTime.of(LocalDateTime.parse(
                                            each[3],
                                            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                                    ),
                                    ZoneId.of("Asia/Seoul")),
                            ZonedDateTime.of(LocalDateTime.parse(
                                            each[4],
                                            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                                    ),
                                    ZoneId.of("Asia/Seoul"))
                    )
            );
        }
        return result;
    }

    public List<OutOfOffice> readOutOfOffice(String path) throws IOException {
        List<OutOfOffice> result = new ArrayList<>();

        // 데이터를 읽는 부분
        List<String[]> read = rawCsvReader.readAll(path);
        for (int i = 0; i < read.size(); i++) {
            if (skipHeader(i)){
                continue;
            }

            String[] each = read.get(i);

            // Out of Office 로 변환 부분
            result.add(
                    new OutOfOffice(
                            Integer.parseInt(each[0]),
                            each[2],
                            ZonedDateTime.of(LocalDateTime.parse(
                                            each[3],
                                            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                                    ),
                                    ZoneId.of("Asia/Seoul")),
                            ZonedDateTime.of(LocalDateTime.parse(
                                            each[4],
                                            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                                    ),
                                    ZoneId.of("Asia/Seoul"))
                    )
            );
        }
        return result;
    }

    public List<Todo> readTodo(String path) throws IOException {
        List<Todo> result = new ArrayList<>();

        // 데이터를 읽는 부분
        List<String[]> read = rawCsvReader.readAll(path);
        for (int i = 0; i < read.size(); i++) {
            if (skipHeader(i)){
                continue;
            }

            String[] each = read.get(i);

            //  투두로 변환 부분
            result.add(
                    new Todo(
                            Integer.parseInt(each[0]),
                            each[2],
                            ZonedDateTime.of(LocalDateTime.parse(
                                            each[4],
                                            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                                    ),
                                    ZoneId.of("Asia/Seoul")),
                            ZonedDateTime.of(LocalDateTime.parse(
                                            each[5],
                                            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                                    ),
                                    ZoneId.of("Asia/Seoul")),
                            each[3]
                    )
            );
        }
        return result;
    }

    private boolean skipHeader(int i) {
        return i == 0;
    }
}

