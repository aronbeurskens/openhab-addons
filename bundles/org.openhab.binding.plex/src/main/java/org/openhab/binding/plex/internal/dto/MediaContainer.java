/**
 * Copyright (c) 2010-2022 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.plex.internal.dto;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 *
 * @author Brian Homeyer - Initial Configuration
 */
@XStreamAlias("MediaContainer")
public class MediaContainer {
    @XStreamAsAttribute
    private Integer size;
    @XStreamImplicit
    @XStreamAsAttribute
    private List<Video> Video = null;

    @XStreamImplicit
    @XStreamAsAttribute
    private List<Track> Track = null;

    @XStreamImplicit
    @XStreamAsAttribute
    private List<Device> Device = null;

    public List<Device> getDevice() {
        return Device;
    }

    public Integer getSize() {
        return size;
    }

    public List<Video> getVideo() { return Video; }

    public List<Track> getTrack() { return Track; }

    /**
     * Returns a list of video or track objects, depends on what is playing
     */
    public List<? extends MediaType> getMediaTypes() {
        if (Video != null) {
            return Video;
        }
        if (Track != null) {
            return Track;
        }

        return null;
    }

    public class MediaType {
        @XStreamAsAttribute
        private String title;
        @XStreamAsAttribute
        private String thumb;
        @XStreamAsAttribute
        private String art;
        @XStreamAsAttribute
        private String grandparentThumb;
        @XStreamAsAttribute
        private String grandparentTitle;
        @XStreamAsAttribute
        private String parentThumb;
        @XStreamAsAttribute
        private String parentTitle;
        @XStreamAsAttribute
        private long viewOffset;
        @XStreamAsAttribute
        private String type;
        @XStreamAsAttribute
        private String sessionKey;
        @XStreamAlias("Media")
        private Media media;
        @XStreamAlias("Player")
        private Player player;

        public String getGrandparentThumb() {
            return this.grandparentThumb;
        }

        public void setGrandparentThumb(String grandparentThumb) {
            this.grandparentThumb = grandparentThumb;
        }

        public String getGrandparentTitle() {
            return this.grandparentTitle;
        }

        public void setGrandparentTitle(String grandparentTitle) {
            this.grandparentTitle = grandparentTitle;
        }

        public String getParentThumb() {
            return this.parentThumb;
        }

        public void setParentThumb(String parentThumb) {
            this.parentThumb = parentThumb;
        }

        public String getParentTitle() {
            return this.parentTitle;
        }

        public void setParentTitle(String parentTitle) {
            this.parentTitle = parentTitle;
        }

        public Media getMedia() {
            return this.media;
        }

        public Player getPlayer() {
            return this.player;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public long getViewOffset() {
            return this.viewOffset;
        }

        public String getType() {
            return this.type;
        }

        public String getThumb() {
            return this.thumb;
        }

        public void setThumb(String art) {
            this.thumb = art;
        }

        public String getArt() {
            return art;
        }

        public void setArt(String art) {
            this.art = art;
        }

        public String getSessionKey() {
            return sessionKey;
        }

        public void setSessionKey(String sessionKey) {
            this.sessionKey = sessionKey;
        }

        public class Player {
            @XStreamAsAttribute
            private String machineIdentifier;
            @XStreamAsAttribute
            private String state;
            @XStreamAsAttribute
            private String local;

            public String getMachineIdentifier() {
                return this.machineIdentifier;
            }

            public String getState() {
                return this.state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getLocal() {
                return this.local;
            }
        }

        public class Media {

            @XStreamAsAttribute
            private long duration;

            public long getDuration() {
                return this.duration;
            }
        }
    }

    @XStreamAlias("Video")
    public class Video extends MediaType {}

    @XStreamAlias("Track")
    public class Track extends MediaType {}

    public class Device {
        @XStreamAsAttribute
        private String name;

        public String getName() {
            return this.name;
        }

        @XStreamAlias("Connection")
        @XStreamImplicit
        private List<Connection> Connection = null;

        public List<Connection> getConnection() {
            return Connection;
        }

        public class Connection {
            @XStreamAsAttribute
            private String protocol;
            @XStreamAsAttribute
            private String address;

            public String getProtocol() {
                return this.protocol;
            }

            public String getAddress() {
                return this.address;
            }
        }
    }
}
