/*
 *    sora-editor - the awesome code editor for Android
 *    https://github.com/Rosemoe/sora-editor
 *    Copyright (C) 2020-2024  Rosemoe
 *
 *     This library is free software; you can redistribute it and/or
 *     modify it under the terms of the GNU Lesser General Public
 *     License as published by the Free Software Foundation; either
 *     version 2.1 of the License, or (at your option) any later version.
 *
 *     This library is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *     Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public
 *     License along with this library; if not, write to the Free Software
 *     Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 *     USA
 *
 *     Please contact Rosemoe by email 2073412493@qq.com if you need
 *     additional information or have any questions
 */
package io.github.rosemoe.sora.event;

import androidx.annotation.NonNull;

import io.github.rosemoe.sora.widget.CodeEditor;

/**
 * Reports a scroll in editor.
 * The scrolling action can either have run or be running when this event is generated and sent.
 * <p>
 * The returned x,y positions are usually positive when over-scrolling is disabled. They represent
 * the left-top position's pixel in editor.
 */
public class ScrollEvent extends Event {
  
  /**
   * Caused by thumb's exact movements
   */
  public final static int CAUSE_USER_DRAG = 1;
  /**
   * Caused by fling after user's movements
   */
  public final static int CAUSE_USER_FLING = 2;
  /**
   * Caused by calling {@link CodeEditor#ensurePositionVisible(int, int)}.
   * This can happen when this method is manually called or either the user edits the text
   */
  public final static int CAUSE_MAKE_POSITION_VISIBLE = 3;
  /**
   * Caused by the user's thumb reaching the edge of editor viewport, which causes the editor to
   * scroll to move the selection to text currently outside the viewport.
   */
  public final static int CAUSE_TEXT_SELECTING = 4;
  
  public final static int CAUSE_SCALE_TEXT = 5;
  
  private final int startX;
  private final int startY;
  private final int endX;
  private final int endY;
  private final int cause;
  private final float flingVelocityX;
  private final float flingVelocityY;
  
  public ScrollEvent(@NonNull CodeEditor editor, int startX, int startY, int endX, int endY, int cause) {
    this(editor, startX, startY, endX, endY, cause, 0f, 0f);
  }
  
  public ScrollEvent(@NonNull CodeEditor editor, int startX, int startY, int endX, int endY, int cause, float vx, float vy) {
    super(editor);
    this.startX = startX;
    this.startY = startY;
    this.endX = endX;
    this.endY = endY;
    this.cause = cause;
    this.flingVelocityX = vx;
    this.flingVelocityY = vy;
  }
  
  /**
   * Get the start x
   */
  public int getStartX() {
    return startX;
  }
  
  /**
   * Get the start y
   */
  public int getStartY() {
    return startY;
  }
  
  /**
   * Get end x
   */
  public int getEndX() {
    return endX;
  }
  
  /**
   * Get end y
   */
  public int getEndY() {
    return endY;
  }
  
  /**
   * Get the cause of the scroll
   */
  public int getCause() {
    return cause;
  }
  
  public float getFlingVelocityX() {
    return flingVelocityX;
  }
  
  public float getFlingVelocityY() {
    return flingVelocityY;
  }
}
