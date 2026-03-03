package com.distributed_lovable.workspace_service.dto.project;

public record FileNode(
        String path
) {

    @Override
    public String toString()
    {
//        return "FileNode{"+ "path='" +path +'\'' +'}'; // instead of this just pass path so as to not confuse the llm

        return path;
    }

}
