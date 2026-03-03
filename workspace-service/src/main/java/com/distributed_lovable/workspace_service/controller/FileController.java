package com.distributed_lovable.workspace_service.controller;

import com.distributed_lovable.workspace_service.dto.project.FileContentResponse;
import com.distributed_lovable.workspace_service.dto.project.FileTreeResponse;
import com.distributed_lovable.workspace_service.service.ProjectFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor // generate objects using constructor now you dont need to write them
@RequestMapping("/api/projects/{projectId}/files")
public class FileController {

    private final ProjectFileService fileServiceObj;

    @GetMapping()
    public ResponseEntity<FileTreeResponse>  getFileTree(@PathVariable Long projectId){

        return ResponseEntity.ok(fileServiceObj.getFileTree(projectId));
    }

    @GetMapping("/content") // * so that I can also get /src/hooks/AppHook.jsx //this get mapping will only work if there is something before path
    public ResponseEntity<FileContentResponse> getFile(
            @PathVariable Long projectId,
            @RequestParam String path
    )
    {

        return ResponseEntity.ok(fileServiceObj.getFileContent(projectId,path));
    }

}
