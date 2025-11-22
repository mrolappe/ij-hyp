package de.rholambdapi.hyp.ij

import com.intellij.icons.AllIcons
import com.intellij.openapi.fileTypes.ex.FileTypeIdentifiableByVirtualFile
import com.intellij.openapi.vfs.VirtualFile

class HypFileType : FileTypeIdentifiableByVirtualFile {
    companion object {
        val INSTANCE = HypFileType()
    }

    override fun getName() = "Hyp"

    override fun getDescription() = "Hypertext"

    override fun getDefaultExtension() = "hyp"

    override fun getIcon() = AllIcons.FileTypes.Html

    override fun isBinary() = true

    override fun isMyFileType(file: VirtualFile): Boolean {
        val isMyType = file.extension == "hyp"
        println("TODO, HypFileType::isMyFileType; file: $file -> isMyType: $isMyType")
        return isMyType
    }
}
