package de.rholambdapi.hyp.ij

import com.intellij.icons.AllIcons
import com.intellij.openapi.fileTypes.ex.FileTypeIdentifiableByVirtualFile
import com.intellij.openapi.vfs.VirtualFile
import javax.swing.Icon

class HypFileType : FileTypeIdentifiableByVirtualFile {
    override fun getName() = "Hyp"

    override fun getDescription() = "Hypertext"

    override fun getDefaultExtension() = "hyp"

    override fun getIcon() = AllIcons.FileTypes.Html

    override fun isBinary() = true

    override fun isMyFileType(file: VirtualFile): Boolean {
        println("TODO, HypFileType::isMyFileType; file: $file")
        return file.extension == "hyp"
    }
}
