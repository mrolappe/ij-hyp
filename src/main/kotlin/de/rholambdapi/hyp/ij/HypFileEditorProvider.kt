package de.rholambdapi.hyp.ij

import com.intellij.openapi.fileEditor.FileEditor
import com.intellij.openapi.fileEditor.FileEditorPolicy
import com.intellij.openapi.fileEditor.FileEditorState
import com.intellij.openapi.fileEditor.WeighedFileEditorProvider
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.UserDataHolderBase
import com.intellij.openapi.vfs.VirtualFile
import java.awt.BorderLayout
import java.beans.PropertyChangeListener
import javax.swing.JPanel

class HypFileEditorProvider : WeighedFileEditorProvider() {
    override fun accept(project: Project, file: VirtualFile): Boolean {
        val accepted = file.fileType == HypFileType.INSTANCE
        println("HypFileEditorProvider::accept; project: $project, file: $file (file type: ${file.fileType}) -> accepted: $accepted")
        return accepted
    }

    override fun createEditor(project: Project, file: VirtualFile): FileEditor {
        return SwingHypViewFileEditor()
    }

    override fun getEditorTypeId() = "hyp-view-editor"

    override fun getPolicy() = FileEditorPolicy.PLACE_AFTER_DEFAULT_EDITOR
}

class SwingHypViewFileEditor : FileEditor, UserDataHolderBase() {
    private val panel = JPanel(BorderLayout())

    override fun dispose() = Unit

    override fun getComponent() = panel

    override fun getPreferredFocusedComponent() = null

    override fun getName() = "Hyp View"

    override fun setState(state: FileEditorState) = Unit

    override fun isModified() = false

    override fun isValid() = true

    override fun addPropertyChangeListener(listener: PropertyChangeListener) = Unit

    override fun removePropertyChangeListener(listener: PropertyChangeListener) = Unit

}