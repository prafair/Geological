package com.task.geological.service;

import com.task.geological.model.Geo;
import com.task.geological.service.response.GeoResponse;
import com.task.geological.util.ImportUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;


@Service
public class ImportService {

    private static final int CLASS_COLUMN_INDEX = 1;

    public GeoResponse importGeo(Geo geos, MultipartFile file, Integer startRowIndex) throws IOException {

        GeoResponse response = new GeoResponse();
        Workbook workbook = new HSSFWorkbook(file.getInputStream());

        Sheet sheet = workbook.getSheetAt(0);

        int rowsNumber = sheet.getPhysicalNumberOfRows();
        //int filesColumnIndex = calcFilesColumnIndex(sheet);

//        response.setDone(true);
//
//        // collect rows and sort them by tunnelmeter asc
//        List<Row> rows = new ArrayList<>();
//        for (int i = startRowIndex; i < rowsNumber; i++) {
//            Row row = sheet.getRow(i);
//            if (row == null || row.getLastCellNum() < (CLASS_COLUMN_INDEX - 1)) {
//                continue;
//            }
//            rows.add(row);
//        }
//        // Collections.sort(rows, GEOLOGY_SECTION_ROW_COMPARATOR);
//        // import sorted sections
//        for (Row row : rows) {
//            try {
//                Geo geo = fetchSection(geos, row, filesColumnIndex);
//                response.getImported().add(geo);
//            } catch (Exception e) {
//                logger.warn("import geology sections", e);
//                response.getErrors().add(e.getMessage());
//                response.setDone(false);
//            }
//        }
//        return response;
//    }
//
////    ImportUtil importUtil = new ImportUtil();
//
////    public List<Map<String, String>> importGeo(MultipartFile file) throws IOException {
////
////        Path tempDir = Files.createTempDirectory("");
////
////        File tempFile = tempDir.resolve(file.getOriginalFilename()).toFile();
////
////        file.transferTo(tempFile);
////
////        Workbook workbook = WorkbookFactory.create(tempFile);
////
////        Sheet sheet = workbook.getSheetAt(0);
////
////        Supplier<Stream<Row>> rowStreamSupplier = importUtil.getRowStreamSupplier(sheet);
////
////        Row headerRow = rowStreamSupplier.get().findFirst().get();
////
////        List<String> headerCells = importUtil.getStream(headerRow)
////                .map(Cell::getStringCellValue)
////                .collect(Collectors.toList());
////
////        final int colCount = headerCells.size();
////
////        return rowStreamSupplier.get()
////                .skip(1)
////                .map(row -> {
////
////                    List<String> cellList = importUtil.getStream(row)
////                            .map(Cell::getStringCellValue)
////                            .collect(Collectors.toList());
////                    //
////                    return importUtil.cellIteratorSupplier(colCount)
////                            .get()
////                            .collect(toMap(headerCells::get, cellList::get));
////                })
////                .collect(Collectors.toList());
////    }
}

